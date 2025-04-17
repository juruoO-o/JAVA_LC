import java.util.*;
import java.io.*;

/**
 * Represents an IP address range with both string and long representations.
 */
class IpRange implements Comparable<IpRange> {
    String startIpStr;
    String endIpStr;
    long startIpLong;
    long endIpLong;
    long ipCount;

    public IpRange(String startIpStr, String endIpStr) {
        this.startIpStr = startIpStr;
        this.endIpStr = endIpStr;
        this.startIpLong = ipToLong(startIpStr);
        this.endIpLong = ipToLong(endIpStr);
        // Ensure endIp is not smaller than startIp, although problem statement guarantees it.
        if (this.endIpLong < this.startIpLong) {
            // Handle error or swap if necessary, though input guarantees end >= start
            // For simplicity, we assume valid input based on the prompt.
            this.ipCount = 0; // Or throw an exception
        } else {
            this.ipCount = this.endIpLong - this.startIpLong + 1;
        }
    }

    /**
     * Converts an IPv4 address string to its long representation.
     * @param ipAddress The IP address string (e.g., "192.168.1.1").
     * @return The long representation of the IP address.
     */
    public static long ipToLong(String ipAddress) {
        String[] parts = ipAddress.split("\\.");
        long result = 0;
        // Check if the split resulted in 4 parts
        if (parts.length != 4) {
            throw new IllegalArgumentException("Invalid IPv4 address format: " + ipAddress);
        }
        try {
            for (int i = 0; i < 4; i++) {
                int part = Integer.parseInt(parts[i]);
                if (part < 0 || part > 255) {
                    throw new IllegalArgumentException("Invalid IPv4 address segment: " + part);
                }
                result += (long)part << (24 - (8 * i));
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid number in IPv4 address: " + ipAddress);
        }
        return result;
    }

    /**
     * Primary sort by end IP (long), secondary sort by start IP (long).
     * Used for the initial sorting of intervals for the DP approach.
     */
    @Override
    public int compareTo(IpRange other) {
        if (this.endIpLong != other.endIpLong) {
            return Long.compare(this.endIpLong, other.endIpLong);
        }
        return Long.compare(this.startIpLong, other.startIpLong);
    }

    @Override
    public String toString() {
        return startIpStr + " " + endIpStr;
    }

    // Comparator for sorting final results by start IP
    public static Comparator<IpRange> startIpComparator() {
        return Comparator.comparingLong(r -> r.startIpLong);
    }
}

/**
 * Represents a potential solution (a set of non-overlapping IP ranges)
 * and implements comparison based on the problem's criteria.
 */
class MySolution implements Comparable<MySolution> {
    List<IpRange> ranges;
    int count;
    long totalIps;

    // Default constructor for an empty solution
    public MySolution() {
        this.ranges = Collections.emptyList(); // Use immutable empty list
        this.count = 0;
        this.totalIps = 0;
    }

    // Constructor to create a solution from a list of ranges
    public MySolution(List<IpRange> ranges) {
        // Create a mutable copy and sort it by start IP for consistent comparison
        this.ranges = new ArrayList<>(ranges);
        this.ranges.sort(IpRange.startIpComparator());
        this.count = this.ranges.size();
        this.totalIps = this.ranges.stream().mapToLong(r -> r.ipCount).sum();
    }

    /**
     * Compares this solution with another based on the problem's criteria:
     * 1. Maximize count (higher count is better/smaller).
     * 2. Minimize total IPs (lower total IPs is better/smaller).
     * 3. Lexicographical order of start IPs (smaller start IPs are better/smaller).
     */
    @Override
    public int compareTo(MySolution other) {
        // 1. Maximize count
        if (this.count != other.count) {
            // Higher count is preferred, so if this.count > other.count, return -1
            return Integer.compare(other.count, this.count);
        }
        // 2. Minimize total IPs
        if (this.totalIps != other.totalIps) {
            // Lower total IPs is preferred
            return Long.compare(this.totalIps, other.totalIps);
        }
        // 3. Lexicographical order of start IPs (lists are pre-sorted by start IP)
        for (int i = 0; i < this.count; i++) {
            long startIp1 = this.ranges.get(i).startIpLong;
            long startIp2 = other.ranges.get(i).startIpLong;
            if (startIp1 != startIp2) {
                return Long.compare(startIp1, startIp2);
            }
            // If start IPs are the same, the problem doesn't specify secondary sort within lexicographical.
            // We can assume start IPs will be unique enough for distinct ranges,
            // or compare end IPs if needed, but sticking to the prompt's focus on start IP.
        }
        // Solutions are considered equal according to the criteria
        return 0;
    }

    /**
     * Creates a new Solution by adding a new range to this one.
     * @param newRange The IpRange to add.
     * @return A new Solution instance containing the old ranges plus the new one.
     */
    public MySolution addRange(IpRange newRange) {
        List<IpRange> newRanges = new ArrayList<>(this.ranges);
        newRanges.add(newRange);
        // The new Solution constructor will sort the combined list
        return new MySolution(newRanges);
    }
}

public class main3 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n;
        try {
            n = Integer.parseInt(reader.readLine());
            if (n < 1 || n > 100) {
                // Handle invalid N based on problem constraints if needed
                System.err.println("Warning: N is outside the expected range [1, 100].");
                // Depending on requirements, could exit or proceed.
                if (n <= 0) return; // Exit if N is non-positive
            }
        } catch (NumberFormatException | IOException e) {
            System.err.println("Error reading number of business requests N.");
            return;
        }


        List<IpRange> intervals = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            try {
                String line = reader.readLine();
                if (line == null) {
                    System.err.println("Error: Unexpected end of input while reading IP ranges.");
                    return;
                }
                String[] parts = line.trim().split("\\s+"); // Split by one or more spaces
                if (parts.length != 2) {
                    System.err.println("Error: Invalid format for IP range on line " + (i + 2) + ": " + line);
                    continue; // Skip this invalid line or handle error as required
                }
                intervals.add(new IpRange(parts[0], parts[1]));
            } catch (IllegalArgumentException e) {
                System.err.println("Error parsing IP range on line " + (i + 2) + ": " + e.getMessage());
                // Skip this invalid line or handle error as required
            } catch (IOException e) {
                System.err.println("Error reading IP range input.");
                return;
            }
        }

        // Handle case where no valid intervals were read
        if (intervals.isEmpty()) {
            // Output nothing or an appropriate message if required
            return;
        }


        // Sort intervals primarily by end IP, secondarily by start IP
        Collections.sort(intervals);

        // DP state: dp[i] stores the best Solution using a subset of the first i+1 intervals
        // (i.e., intervals from index 0 to i in the sorted list).
        MySolution[] dp = new MySolution[intervals.size()];

        // Base case: dp[0] is the solution containing only the first interval
        dp[0] = new MySolution(Collections.singletonList(intervals.get(0)));

        // Fill DP table
        for (int i = 1; i < intervals.size(); i++) {
            IpRange currentInterval = intervals.get(i);

            // --- Calculate the best solution *ending* with interval i ---
            MySolution bestPrevSolutionForInclusion = new MySolution(); // Start with an empty solution

            // Find the latest interval j < i that is compatible (doesn't overlap)
            int prevCompatibleIndex = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (intervals.get(j).endIpLong < currentInterval.startIpLong) {
                    prevCompatibleIndex = j;
                    break; // Found the latest compatible interval's index
                }
            }

            // If a compatible previous interval exists, combine currentInterval with the best solution up to that point (dp[j])
            if (prevCompatibleIndex != -1) {
                bestPrevSolutionForInclusion = dp[prevCompatibleIndex];
            }
            // Create the potential solution that includes the current interval
            MySolution solutionIncludingCurrent = bestPrevSolutionForInclusion.addRange(currentInterval);


            // --- Compare with the best solution *excluding* interval i ---
            // The best solution excluding interval i is simply the best solution found using intervals up to i-1
            MySolution solutionExcludingCurrent = dp[i - 1];

            // --- Determine dp[i] ---
            // dp[i] is the better one between including currentInterval and excluding it, based on Solution.compareTo
            if (solutionIncludingCurrent.compareTo(solutionExcludingCurrent) < 0) {
                // solutionIncludingCurrent is better (smaller comparison result)
                dp[i] = solutionIncludingCurrent;
            } else {
                // solutionExcludingCurrent is better or equal
                dp[i] = solutionExcludingCurrent;
            }
        }

        // The final best solution considering all intervals is in the last element of the DP table
        MySolution finalSolution = dp[intervals.size() - 1];

        // Output the selected ranges, already sorted by start IP within the Solution object
        for (IpRange range : finalSolution.ranges) {
            System.out.println(range.toString());
        }
    }
}
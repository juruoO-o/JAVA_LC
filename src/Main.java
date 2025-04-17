import java.util.*;

public class Main {
    // 站点类，包含站点名称和所在线路
    static class Station {
        String name;
        int line;

        Station(String name, int line) {
            this.name = name;
            this.line = line;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Station station = (Station) o;
            return line == station.line && name.equals(station.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, line);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        // 存储每条线路的站点列表
        List<List<String>> lines = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] stations = scanner.nextLine().split(" ");
            lines.add(Arrays.asList(stations));
        }

        String start = scanner.next();
        String end = scanner.next();

        // 构建图
        Map<Station, List<Station>> graph = buildGraph(lines);

        // 进行广度优先搜索
        List<Station> path = bfs(graph, lines, start, end);

        if (path == null) {
            System.out.println("NA");
        } else {
            // 输出路径
            StringBuilder pathStr = new StringBuilder();
            for (int i = 0; i < path.size(); i++) {
                if (i > 0) {
                    pathStr.append("-");
                }
                pathStr.append(path.get(i).name);
            }
            System.out.println(pathStr);

            // 计算票价
            int transferCount = 0;
            int currentLine = path.get(0).line;
            for (int i = 1; i < path.size(); i++) {
                if (path.get(i).line != currentLine) {
                    transferCount++;
                    currentLine = path.get(i).line;
                }
            }
            int fare = 2 + transferCount;
            System.out.println(fare);
        }
    }

    // 构建图
    private static Map<Station, List<Station>> buildGraph(List<List<String>> lines) {
        Map<Station, List<Station>> graph = new HashMap<>();
        for (int line = 0; line < lines.size(); line++) {
            List<String> stations = lines.get(line);
            for (int i = 0; i < stations.size(); i++) {
                Station current = new Station(stations.get(i), line);
                graph.putIfAbsent(current, new ArrayList<>());

                // 添加同线路的相邻站点
                if (i > 0) {
                    Station prev = new Station(stations.get(i - 1), line);
                    graph.get(current).add(prev);
                }
                if (i < stations.size() - 1) {
                    Station next = new Station(stations.get(i + 1), line);
                    graph.get(current).add(next);
                }

                // 添加换乘站点
                for (int otherLine = 0; otherLine < lines.size(); otherLine++) {
                    if (otherLine != line) {
                        List<String> otherStations = lines.get(otherLine);
                        if (otherStations.contains(stations.get(i))) {
                            int index = otherStations.indexOf(stations.get(i));
                            Station transfer = new Station(stations.get(i), otherLine);
                            graph.get(current).add(transfer);
                        }
                    }
                }
            }
        }
        return graph;
    }

    // 广度优先搜索
    private static List<Station> bfs(Map<Station, List<Station>> graph, List<List<String>> lines, String start, String end) {
        Queue<List<Station>> queue = new LinkedList<>();
        Set<Station> visited = new HashSet<>();

        // 初始化起点
        for (int line = 0; line < lines.size(); line++) {
            if (lines.get(line).contains(start)) {
                Station startStation = new Station(start, line);
                List<Station> path = new ArrayList<>();
                path.add(startStation);
                queue.offer(path);
                visited.add(startStation);
            }
        }

        while (!queue.isEmpty()) {
            List<Station> path = queue.poll();
            Station current = path.get(path.size() - 1);

            if (current.name.equals(end)) {
                // 处理路径，去除重复站点
                List<Station> finalPath = new ArrayList<>();
                finalPath.add(path.get(0));
                for (int i = 1; i < path.size(); i++) {
                    if (!path.get(i).name.equals(finalPath.get(finalPath.size() - 1).name)) {
                        finalPath.add(path.get(i));
                    }
                }
                return finalPath;
            }

            for (Station neighbor : graph.get(current)) {
                if (!visited.contains(neighbor)) {
                    List<Station> newPath = new ArrayList<>(path);
                    newPath.add(neighbor);
                    queue.offer(newPath);
                    visited.add(neighbor);
                }
            }
        }
        return null;
    }
}
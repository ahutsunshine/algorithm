package com.algorithm.ebay;

import java.util.*;

class Coordinate {
    int x;
    int y;

    Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

class MapValue {
    Coordinate coordinate;
    int weight;

    MapValue(Coordinate coordinate, int weight) {
        this.coordinate = coordinate;
        this.weight = weight;
    }
}

public class FamilyDay {


    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Map<Coordinate, List<MapValue>> map = new HashMap<>();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] nums = new int[n][5];
        in.nextLine();

        int endStart = 0;
        for (int i = 0; i < n; i++) {
            String meeting = in.nextLine();
            String[] times = meeting.split(" ");
            nums[i][0] = Integer.parseInt(times[0]);
            nums[i][1] = Integer.parseInt(times[1]);
            nums[i][2] = Integer.parseInt(times[2]);
            nums[i][3] = Integer.parseInt(times[3]);
            nums[i][4] = Integer.parseInt(times[4]);
            if (endStart < nums[i][2]) {
                endStart = nums[i][2];
            }
        }
        Coordinate start = new Coordinate(0, 0);
        for (int i = 0; i < n; i++) {
            Coordinate first = new Coordinate(nums[i][0], nums[i][1]);
            Coordinate second = new Coordinate(nums[i][2], nums[i][3]);
            if (first.x == 0 && first.y == 0) {
                start = first;
            }
            MapValue mv = new MapValue(second, nums[i][4]);
            if (!map.containsKey(first)) {
                List<MapValue> list = new ArrayList<>();
                map.put(first, list);
            }
            map.get(first).add(mv);
        }
        Map<Coordinate, Integer> memoMax = new HashMap<>();
        Map<Coordinate, Integer> memoMin = new HashMap<>();

        System.out.println(getMin(map, start, memoMin)+" "+getMax(map, start, memoMax));
    }

    public static int getMax(Map<Coordinate, List<MapValue>> map, Coordinate c, Map<Coordinate, Integer> memoMax) {

        if (!map.containsKey(c)) {
            return 0;
        }
//
//        for (MapValue m : map.get(c)) {
//            getMax(map, m.coordinate, sum + m.weight);
//        }
        int max = Integer.MIN_VALUE;
        for(MapValue mv: map.get(c)){
            if(!memoMax.containsKey(mv.coordinate)){
                memoMax.put(mv.coordinate, getMax(map, mv.coordinate, memoMax));
            }

            if(max<memoMax.get(mv.coordinate)+ mv.weight){
                max = memoMax.get(mv.coordinate)+ mv.weight;
            }
        }
        return max;
    }
    public static int getMin(Map<Coordinate, List<MapValue>> map, Coordinate c, Map<Coordinate, Integer> memoMax) {

        if (!map.containsKey(c)) {
            return 0;
        }
//
//        for (MapValue m : map.get(c)) {
//            getMax(map, m.coordinate, sum + m.weight);
//        }
        int max = Integer.MAX_VALUE;
        for(MapValue mv: map.get(c)){
            if(!memoMax.containsKey(mv.coordinate)){
                memoMax.put(mv.coordinate, getMin(map, mv.coordinate, memoMax));
            }

            if(max>memoMax.get(mv.coordinate)+ mv.weight){
                max = memoMax.get(mv.coordinate)+ mv.weight;
            }
        }
        return max;
    }
}

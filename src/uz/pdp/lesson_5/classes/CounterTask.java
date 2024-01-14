package uz.pdp.lesson_5.classes;

import java.util.concurrent.RecursiveTask;

public class CounterTask extends RecursiveTask<Integer> {

    private int begin;
    private int end;
    private int[] arr;

    private int limit = 1000;

    public CounterTask(int begin, int end, int[] arr) {
        this.begin = begin;
        this.end = end;
        this.arr = arr;
    }

    @Override
    protected Integer compute() {
        if (end - begin <= limit) {
            int counter = 0;
            for (int i = begin; i < end; i++) {
                if (arr[i] >= 5) {
                    counter++;
                }
            }
            return counter;

        } else {
            int mid = begin + (end - begin) / 2;
            var part1 = new CounterTask(begin, mid, arr);
            var part2 = new CounterTask(mid, end, arr);
            invokeAll(part1, part2);
            return part1.join() + part2.join();
        }
    }
}

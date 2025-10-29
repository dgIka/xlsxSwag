package org.xslxSwag.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SelectNService {

    public int findNSmallest(List<Integer> list, int n) {
        if (n < 1 || n > list.size()) {
            throw new IllegalArgumentException("Invalid N");
        }
        return quickSelect(list, 0, list.size() - 1, n - 1);
    }

    private int quickSelect(List<Integer> column, int left, int right, int k) {
        if (left == right) return column.get(left);

        int pivot = split(column, left, right);
        if (k == pivot) return column.get(k);
        else if (k < pivot) return quickSelect(column, left, pivot - 1, k);
        else return quickSelect(column, pivot + 1, right, k);
    }

    private int split(List<Integer> column, int left, int right) {
        int pivot = left + (int) (Math.random() * (right - left + 1));
        int pivotValue = column.get(pivot);
        swap(column, pivot, right);

        int tempIndex = left;
        for (int i = left; i < right; i++) {
            if (column.get(i) < pivotValue) {
                swap(column, i, tempIndex++);
            }
        }

        swap(column, tempIndex, right);
        return tempIndex;
    }

    private void swap(List<Integer> column, int i, int j) {
        int tmp = column.get(i);
        column.set(i, column.get(j));
        column.set(j, tmp);
    }
}

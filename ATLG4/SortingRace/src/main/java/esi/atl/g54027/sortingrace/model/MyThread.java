package esi.atl.g54027.sortingrace.model;

import esi.atl.g54027.sortingrace.model.sorts.Sort;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.time.LocalTime;

import static java.time.temporal.ChronoUnit.MILLIS;

public class MyThread extends Thread {
    private final Job job;
    private final Sort sortType;
    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public MyThread(Job job, Sort sortType) {
        this.job = job;
        this.sortType = sortType;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }

    @Override
    public void run() {
        long duration;
        int[] tabToSort = job.makeJob();

        while (tabToSort != null) {
            LocalTime start = LocalTime.now();
            duration = sortType.sort(tabToSort);
            LocalTime end = LocalTime.now();

            pcs.firePropertyChange("notUsed", null, new long[]{
                    tabToSort.length,
                    duration,
                    (int) MILLIS.between(start, end)
            });
            tabToSort = job.makeJob();
        }
    }
}

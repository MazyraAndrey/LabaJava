package org.example;

public interface Patricipant {

        boolean jump(int height);
        boolean run(int dist);
        default boolean superRun(boolean superRunCount) {
            return superRunCount;
        }

    }



package com.example.anni.observer;

    public class ObserverThread extends Thread {

        public int identifier = 0;
        public int Progress = 0;
        public ObserverCounter counter;

        public void setCounter(ObserverCounter counter) {

            this.counter = counter;
        }

        public void run() {
            try {
                while (Progress < 101) {
                    if (counter != null) {
                        counter.observeNow("Thread id " + identifier + ", progress: " + Progress + "%\n");
                        Progress = Progress + 10;
                        sleep(3000);
                    }
                }
            } catch (Exception e) {

                e.printStackTrace();

                    }
                }
            }
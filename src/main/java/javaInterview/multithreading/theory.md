### Thread Lifecycle

##### NEW
A new thread begins its lifecycle in this state & remains here until the program starts the thread

##### RUNNABLE
Once a newly born thread starts, the thread comes under runnable state. Remains in this state 
until the execution starts

##### RUNNING
In this state thread starts executing the run() method and the yield() method can send them to go 
back to the runnable state

##### WAITING
A thread enters this state when it is temporarily in an inactive state i.e. it is still alive but is not
eligible to run. It can be in waiting, sleeping or blocked state.

##### TERMINATED
A runnable thread enters the terminated state when it completes its task or otherwise terminates


### How to create Thread

#### Thread Class

Create a thread class and override the run method, create object of class and invoke start method

    class MyThread extends Thread {
        public void run() {
            // Do Task
        }    
    }

#### Runnable Interface

    class MyThread implements Runnable{

        public void run() {
            Do Task
        }
    }

    




package uz.pdp.lesson_2.threadProject.classes;

import uz.pdp.lesson_2.threadProject.util.Input;

public class File {
    private String name;
    private double size;
    private int downloaded=0;
    private Status status=Status.NEW;
    private boolean active=true;
    private Thread thread=new Thread(getRunnable());

    public File(String name, double size) {
        this.name = name;
        this.size = size;
    }
    private Runnable getRunnable(){
        return  ()->{
            while(true){
                if(downloaded==100){
                    break;
                }
                downloaded++;
                if(active) {
                    System.out.println("Downloaeded(1-Stop, 2-Exit):" + downloaded);
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            status=Status.DOWNLOADED;

        };
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public int getDownloaded() {
        return downloaded;
    }

    public void setDownloaded(int downloaded) {
        this.downloaded = downloaded;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return name+" "+size+" "+status+" "+downloaded;
    }

    public void showInfo() {
        System.out.println("File:" + name);
        System.out.println("Size:" + size);
        System.out.println("Status:" + status);
        System.out.println("Downloaded:" + downloaded);
        active=true;
        while (true) {
            switch (status) {
                case NEW -> {
                    System.out.println("""
                            1-Download
                            2-Back
                            """);
                    switch (Input.inputInt("Choose:")) {
                        case 1 -> {
                            download();

                        }
                        case 2 -> {

                        }
                    }

                }
                case DOWNLOADING -> {
                    switch (Input.inputInt("")){
                        case 1->{
                            thread.interrupt();
                            status=Status.PAUSED;
                            return;
                        }
                        case 2->{
                            active=false;
                            return;
                        }
                    }
                }
                case PAUSED -> {
                    System.out.println("""
                            1-Resume
                            2-Back
                            """);
                    switch (Input.inputInt("Choose:")){
                        case 1->{
                            resumeDownload();
                        }
                        case 2->{
                            return;
                        }
                    }
                }
            }
        }
    }

    private void resumeDownload() {
        thread=new Thread(getRunnable());
        download();

    }

    private void download() {
        thread.start();
        setName(name);
        status=Status.DOWNLOADING;
        active=true;

    }
}

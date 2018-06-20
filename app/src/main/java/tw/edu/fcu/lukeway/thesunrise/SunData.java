package tw.edu.fcu.lukeway.thesunrise;

public class SunData {

    private String spec;
    private String date;
    private String uptime;
    private String downtime;

    public SunData(String spec, String date, String uptime, String downtime) {
        this.spec = spec;
        this.date = date;
        this.uptime = uptime;
        this.downtime = downtime;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUptime() {
        return uptime;
    }

    public void setUptime(String uptime) {
        this.uptime = uptime;
    }

    public String getDowntime() {
        return downtime;
    }

    public void setDowntime(String downtime) {
        this.downtime = downtime;
    }
}

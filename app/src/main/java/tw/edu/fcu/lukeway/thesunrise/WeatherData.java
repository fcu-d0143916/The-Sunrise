package tw.edu.fcu.lukeway.thesunrise;

public class WeatherData {
    private String weatherIconMorning;
    private String weatherIconNight;
    private String temperatureMorningHigh;
    private String temperatureMorningDown;
    private String temperatureNightHigh;
    private String temperatureNightDown;
    private String rainProbabilityMorning;
    private String rainProbabilityNight;

    public WeatherData(String weatherIconMorning, String weatherIconNight, String temperatureMorningHigh, String temperatureMorningDown, String temperatureNightHigh, String temperatureNightDown, String rainProbabilityMorning, String rainProbabilityNight) {
        this.weatherIconMorning = weatherIconMorning;
        this.weatherIconNight = weatherIconNight;
        this.temperatureMorningHigh = temperatureMorningHigh;
        this.temperatureMorningDown = temperatureMorningDown;
        this.temperatureNightHigh = temperatureNightHigh;
        this.temperatureNightDown = temperatureNightDown;
        this.rainProbabilityMorning = rainProbabilityMorning;
        this.rainProbabilityNight = rainProbabilityNight;
    }

    public String getWeatherIconMorning() {
        return weatherIconMorning;
    }

    public void setWeatherIconMorning(String weatherIconMorning) {
        this.weatherIconMorning = weatherIconMorning;
    }

    public String getWeatherIconNight() {
        return weatherIconNight;
    }

    public void setWeatherIconNight(String weatherIconNight) {
        this.weatherIconNight = weatherIconNight;
    }

    public String getTemperatureMorningHigh() {
        return temperatureMorningHigh;
    }

    public void setTemperatureMorningHigh(String temperatureMorningHigh) {
        this.temperatureMorningHigh = temperatureMorningHigh;
    }

    public String getTemperatureMorningDown() {
        return temperatureMorningDown;
    }

    public void setTemperatureMorningDown(String temperatureMorningDown) {
        this.temperatureMorningDown = temperatureMorningDown;
    }

    public String getTemperatureNightHigh() {
        return temperatureNightHigh;
    }

    public void setTemperatureNightHigh(String temperatureNightHigh) {
        this.temperatureNightHigh = temperatureNightHigh;
    }

    public String getTemperatureNightDown() {
        return temperatureNightDown;
    }

    public void setTemperatureNightDown(String temperatureNightDown) {
        this.temperatureNightDown = temperatureNightDown;
    }

    public String getRainProbabilityMorning() {
        return rainProbabilityMorning;
    }

    public void setRainProbabilityMorning(String rainProbabilityMorning) {
        this.rainProbabilityMorning = rainProbabilityMorning;
    }

    public String getRainProbabilityNight() {
        return rainProbabilityNight;
    }

    public void setRainProbabilityNight(String rainProbabilityNight) {
        this.rainProbabilityNight = rainProbabilityNight;
    }
}

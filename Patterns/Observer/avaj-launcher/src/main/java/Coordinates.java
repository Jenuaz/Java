public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;

    Coordinates()
    {
        this.longitude = 0;
        this.latitude = 0;
        this.height = 0;
    }

    Coordinates(int longitude, int latitude, int height)
    {
        this.longitude = longitude;
        this.latitude = latitude;
        this.height = height;
    }

    public int getLongitude() {
        return longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public int getHeight() {
        return height;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void correlateLongitude(int longitude) {
        this.longitude += longitude;
    }

    public void correlateLatitude(int latitude) {
        this.latitude += latitude;
    }

    public void correlateHeight(int height) {
        this.height += height;
    }
}

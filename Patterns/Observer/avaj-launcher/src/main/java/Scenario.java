public class Scenario {
    private String type;
    private String name;
    private Boolean valid = true;
    private Integer iterator;
    private Coordinates coords = new Coordinates();

    public Scenario(String st) {
        this.iterator = 0;
        String[] arrayOrParts = st.split(" ");

        if (arrayOrParts.length == 5) {
            while (this.iterator < arrayOrParts.length) {
                switch(this.iterator) {
                    case 0:
                    {
                        this.type = arrayOrParts[0];
                        break;
                    }
                    case 1:
                    {
                        this.name = arrayOrParts[1];
                        break;
                    }
                    case 2:
                    {
                        this.coords.setHeight(Integer.parseInt(arrayOrParts[2]));
                        break;
                    }
                    case 3:
                    {
                        this.coords.setLatitude(Integer.parseInt(arrayOrParts[3]));
                        break;
                    }
                    case 4:
                    {
                        this.coords.setLongitude(Integer.parseInt(arrayOrParts[4]));
                        break;
                    }
                    case 5:
                    {
                        this.valid = false;
                        break;
                    }
                    default: {
                        break;
                    }
                }
                System.out.println(arrayOrParts[this.iterator++]);
            }
        }
        else
            this.valid = false;
    }

    private Boolean bringOutType() {
        return true;
    }

    private Boolean bringOutName() {
        return true;
    }

    private Boolean bringOutCoords() {
        return true;
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }
    public Coordinates getCoords() {
        return this.coords;
    }

    public Boolean getValid(){
        return this.valid;
    }
}

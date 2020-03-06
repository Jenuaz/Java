package system;

public enum CreateOrDownloadPlayer {
    CREATE_PLAYER (1),
    DOWNLOAD_PLAYER (2);

    private Integer statement;

    CreateOrDownloadPlayer(Integer i) {
        this.statement = i;
    }
    public int getValue(){return statement;}
}

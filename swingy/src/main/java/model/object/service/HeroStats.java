package model.object.service;

public class HeroStats {
    public HeroStats() {
    }

    private int exp;
    private int lvl;
    private int attack;
    private int hitp;
    private int protection;
    private String type;
    private int pow;

    public HeroStats(String type, int lvl, int attack, int protection, int hitp, int exp) {
        this.type = type;
        this.lvl = lvl;
        this.protection = protection;
        this.hitp = hitp;
        this.exp = exp;
        this.attack = attack;
        this.pow = attack + protection;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return (this.type);
    }

    public int getExp() {
        return (this.exp);
    }

    public int getLvl() {
        return (this.lvl);
    }

    public int getAttack() {
        return (this.attack);
    }

    public int getHitp() {
        return (this.hitp);
    }

    public int getProtection() {
        return (this.protection);
    }

    public int getPow() {
        return (this.pow);
    }


    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public void setHitp(int hitp) {
        this.hitp += hitp;

        if (this.hitp <= 0) {
            this.hitp = 0;
        }
    }

    public void setProtection(int protection) {
        this.protection += protection;

        if (this.protection <= 0) {
            this.protection = 0;
        }
    }


}

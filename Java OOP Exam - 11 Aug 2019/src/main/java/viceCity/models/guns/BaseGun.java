package viceCity.models.guns;

import viceCity.common.ExceptionMessages;

public abstract class BaseGun implements Gun{
    private String name;
    private int bulletsPerBarrel;
    private int totalBullets;
    private int barrelCapacity;

    public BaseGun(String name, int bulletsPerBarrel, int totalBullets) {
        this.setName(name);
        this.setBulletsPerBarrel(bulletsPerBarrel);
        this.setTotalBullets(totalBullets);
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty())
            throw new NullPointerException(ExceptionMessages.NAME_NULL);

        this.name = name;
    }

    public void setBulletsPerBarrel(int bulletsPerBarrel) {
        if (bulletsPerBarrel < 0)
            throw new IllegalArgumentException(ExceptionMessages.BULLETS_LESS_THAN_ZERO);
        this.barrelCapacity = bulletsPerBarrel;
        this.bulletsPerBarrel = bulletsPerBarrel;
    }

    public void setTotalBullets(int totalBullets) {
        if (totalBullets < 0)
            throw new IllegalArgumentException(ExceptionMessages.TOTAL_BULLETS_LESS_THAN_ZERO);
        this.totalBullets = totalBullets;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getBulletsPerBarrel() {
        return bulletsPerBarrel;
    }

    @Override
    public int getTotalBullets() {
        return totalBullets;
    }

    @Override
    public abstract int fire();

    @Override
    public boolean canFire() {
        return this.totalBullets > 0 || this.bulletsPerBarrel > 0;
    }

    protected int decreaseBulletsInBarrel (int bullets){
        this.bulletsPerBarrel -= bullets;

        if (this.bulletsPerBarrel < 0){
            int firedBullets = bullets + this.bulletsPerBarrel;
            this.bulletsPerBarrel = 0;
            return firedBullets;
        }

        return bullets;
    }


    protected void reload() {
        if (this.totalBullets > 0) {
            int bulletsToReload = this.barrelCapacity - this.bulletsPerBarrel;
            this.bulletsPerBarrel += bulletsToReload;
            this.totalBullets -= bulletsToReload;
        }
    }
}

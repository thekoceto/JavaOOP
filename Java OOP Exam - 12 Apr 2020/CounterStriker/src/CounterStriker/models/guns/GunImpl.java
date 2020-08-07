package CounterStriker.models.guns;

import CounterStriker.common.ExceptionMessages;

public abstract class GunImpl implements Gun{
    private String name;
    private int bulletsCount;

    public GunImpl(String name, int bulletsCount) {
        this.setName(name);
        this.setBulletsCount(bulletsCount);
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty())
            throw new NullPointerException(ExceptionMessages.INVALID_GUN_NAME);
        this.name = name;
    }

    public void setBulletsCount(int bulletsCount) {
        if (bulletsCount < 0)
            throw new IllegalArgumentException(ExceptionMessages.INVALID_GUN_BULLETS_COUNT);
        this.bulletsCount = bulletsCount;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getBulletsCount() {
        return this.bulletsCount;
    }

    public abstract int fire() ;

    protected int decreaseBullets (int bullets){
        this.bulletsCount -= bullets;

        if (this.bulletsCount < 0){
            int firedBullets = bullets + this.bulletsCount;
            this.bulletsCount = 0;
            return firedBullets;
        }

        return bullets;
    }
}

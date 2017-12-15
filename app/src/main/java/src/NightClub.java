package src;

/**
 * Created by eliztekcan on 27.10.2017.
 */

public class NightClub extends Outdoor
{
    //TO DO
    private final int MAX_SHAKE = 100;
    private int shakeAmount;


    public int getMAX_SHAKE()
    {
        return MAX_SHAKE;
    }

    public int getShakeAmount()
    {
        return shakeAmount;
    }

    public void setShakeAmount(int shakeAmount)
    {
        this.shakeAmount = shakeAmount;
    }

    @Override
    public boolean isChallengeSuccess() {
       if(getShakeAmount() > getMAX_SHAKE()){
           return true;
       }
       else
           return false;
    }
}
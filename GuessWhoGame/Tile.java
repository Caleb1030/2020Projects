import java.util.ArrayList;

public class Tile{
    //visible was created as a backup if I planned on doing the GUI, all of the other parameters coorespond with the xml sheet given
    private String name, saberColor, visible, jedi, droid, humanLike, wookie, darkSide, lightSide, bountyHunter, smuggler, empire, rebel, resistance, firstOrder, seperatist, galacticRepublic, 
    ewok, fluffy, slimey, tall, shorty, pilot, annoying, cute, banderFav, gotButtWhooped, insideATauntuan, stillLiving, lostALimb, spaceBallsChar, kesselSpeed;
    private Boolean visable;

    public Tile(ArrayList<String> inputArr){
        this.visable= true;
        this.name= inputArr.get(0);
        this.jedi= inputArr.get(1);
        this.droid= inputArr.get(2);
        this.humanLike= inputArr.get(3);
        this.wookie= inputArr.get(4);
        this.darkSide= inputArr.get(5);
        this.lightSide= inputArr.get(6);
        this.bountyHunter= inputArr.get(7);
        this.smuggler= inputArr.get(8);
        this.kesselSpeed= inputArr.get(9);
        this.empire= inputArr.get(10);
        this.rebel= inputArr.get(11);
        this.resistance= inputArr.get(12);
        this.firstOrder= inputArr.get(13);
        this.seperatist= inputArr.get(14);
        this.galacticRepublic= inputArr.get(15);
        this.ewok= inputArr.get(16);
        this.fluffy= inputArr.get(17);
        this.slimey= inputArr.get(18);
        this.saberColor= inputArr.get(19);
        this.tall= inputArr.get(20);
        this.shorty= inputArr.get(21);
        this.pilot= inputArr.get(22);
        this.annoying= inputArr.get(23);
        this.cute= inputArr.get(24);
        this.banderFav= inputArr.get(25);
        this.gotButtWhooped = inputArr.get(26);
        this.insideATauntuan= inputArr.get(27);
        this.stillLiving= inputArr.get(28);
        this.lostALimb= inputArr.get(29);
        this.spaceBallsChar= inputArr.get(30);
    }

    
    //getters needed for the list at the bottom
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
    
    public String getJedi(){
        return jedi;
    }

    public String getDroid() {
        return droid;
    }

    public String getHumanLike() {
        return humanLike;
    }

    public String getWookie() {
        return wookie;
    }

    public String getDarkSide() {
        return darkSide;
    }

    public String getLightSide() {
        return lightSide;
    }

    public String getBountyHunter() {
        return bountyHunter;
    }

    public String getSmuggler() {
        return smuggler;
    }

    public String getKesselSpeed() {
        return kesselSpeed;
    }

    public String getEmpire() {
        return empire;
    }

    public String getRebel() {
        return rebel;
    }

    public String getResistance() {
        return resistance;
    }

    public String getFirstOrder() {
        return firstOrder;
    }

    public String getSeperatist() {
        return seperatist;
    }

    public String getGalacticRepublic() {
        return galacticRepublic;
    }

    public String getEwok() {
        return ewok;
    }

    public String getFluffy() {
        return fluffy;
    }

    public String getSlimey() {
        return slimey;
    }

    public String getSaberColor() {
        return saberColor;
    }

    public String getTall() {
        return tall;
    }

    public String getShorty() {
        return shorty;
    }

    public String getPilot() {
        return pilot;
    }

    public String getAnnoying() {
        return annoying;
    }

    public String getCute() {
        return cute;
    }

    public String getBanderFav() {
        return banderFav;
    }

    public String getGotButtWhooped() {
        return gotButtWhooped;
    }

    public String getInsideATauntuan() {
        return insideATauntuan;
    }

    public String getStillLiving() {
        return stillLiving;
    }
    
    public String getLostALimb() {
        return lostALimb;
    }

    public String getSpaceBallsChar() {
        return spaceBallsChar;
    }

    //returns a string array list
    public ArrayList<String> getInputArr(){
        ArrayList<String> values = new ArrayList<String>();
        values.add(this.getName());
        values.add(this.getJedi());
        values.add(this.getDroid());
        values.add(this.getHumanLike());
        values.add(this.getWookie());
        values.add(this.getDarkSide());
        values.add(this.getLightSide());
        values.add(this.getBountyHunter());
        values.add(this.getSmuggler());
        values.add(this.getKesselSpeed());
        values.add(this.getEmpire());
        values.add(this.getRebel());
        values.add(this.getResistance());
        values.add(this.getFirstOrder());
        values.add(this.getSeperatist());
        values.add(this.getGalacticRepublic());
        values.add(this.getEwok());
        values.add(this.getFluffy());
        values.add(this.getSlimey());
        values.add(this.getSaberColor());
        values.add(this.getTall());
        values.add(this.getShorty());
        values.add(this.getPilot());
        values.add(this.getAnnoying());
        values.add(this.getCute());
        values.add(this.getBanderFav());
        values.add(this.getGotButtWhooped());
        values.add(this.getInsideATauntuan());
        values.add(this.getStillLiving());
        values.add(this.getLostALimb());
        values.add(this.getSpaceBallsChar());
        //Test
        //System.out.println(values.size());
        return values;
    }
}
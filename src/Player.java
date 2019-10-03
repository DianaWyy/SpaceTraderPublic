import java.util.Map;

public class Player {
    private String username;
    private Map<String, Integer> fullSkills;
    private Region location;
    private int credits;


    public Player(){
        username = LoginPage.name;
        fullSkills.put("Pilot",LoginPage.pilotSkill);
        fullSkills.put("Fighter", LoginPage.fighterSkill);
        fullSkills.put("Merchant", LoginPage.merchantSkill);
        fullSkills.put("Engineer", LoginPage.engineerSkill);
        Region myRegion = Universe.allRegion.get((int)(Math.random() * Universe.getNum()));
        credits = 0;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String n) {
        username = n;
    }

    public Map getFullSkills() {
        return fullSkills;
    }

    public int getPilotSkill() {
        return fullSkills.get("Pilot");
    }

    public void setPilotSkill(int pilotSkill) {
        fullSkills.replace("Pilot", pilotSkill);
    }

    public int getFighterSkill() {
        return fullSkills.get("Fighter");
    }

    public void setFighterSkill(int fighterSkill) {
        fullSkills.replace("Fighter", fighterSkill);
    }

    public int getMerchantSkill() {
        return fullSkills.get("Merchant");
    }

    public void setMerchantSkill(int merchantSkill) {
        fullSkills.replace("Merchant", merchantSkill);
    }

    public int getEngineerSkill() {
        return fullSkills.get("Engineer");
    }

    public void setEngineerSkill(int engineerSkill) {
        fullSkills.replace("Engineer", engineerSkill);
    }

    public void setCredits(int c) {
        credits = c;
    }

    public int getCredits() {
        return credits;
    }
}

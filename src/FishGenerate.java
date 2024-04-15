import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class FishGenerate implements ActionListener{
    private Timer t;
    private static ArrayList<String> availableFishes;
    private static HashMap<String,Integer> pointValue;
    public static boolean spawnSpecial;

    public FishGenerate(){
        availableFishes = new ArrayList<>();
        pointValue = new HashMap<>();
        t = new Timer(6000,this);
        generateAvailableFishes();
    }

    public ArrayList<Fish> generateFishes(int width)
    {

        ArrayList<Fish> generatedFishes = new ArrayList<>();
        if(spawnSpecial)
        {
            generatedFishes.add(new WalkerFish());
            spawnSpecial = false;
        }
        for(int i = 0; i < width/100+5;i++)
        {
            int dice = (int)(Math.random()*100);
            String[] fishInfo;
            if(dice<5)
            {
                fishInfo = availableFishes.get(3).split(" ");
            }
            else if(dice<10)
            {
                fishInfo = availableFishes.get(4).split(" ");
            }
            else if(dice<20)
            {
                fishInfo = availableFishes.get(2).split(" ");
            }
            else if(dice<50)
            {
                fishInfo = availableFishes.get(0).split(" ");
            }
            else{
                fishInfo = availableFishes.get(1).split(" ");
            }
            generatedFishes.add(new Fish(fishInfo[0],pointValue.get(fishInfo[0]) ,Integer.parseInt(fishInfo[1]),Integer.parseInt(fishInfo[2]),Integer.parseInt(fishInfo[3])));
        }
        generatedFishes.add(new Fish("treasureChest",100,10,10,0));
        return generatedFishes;
    }

    public void startTimer()
    {
        t.start();
    }
    public void actionPerformed(ActionEvent e) {
        spawnSpecial = true;
    }

    public void generateAvailableFishes()
    {
        availableFishes.add("bass 3 2 70");
        pointValue.put("bass",40);
        availableFishes.add("goldfish 6 7 100");
        pointValue.put("goldfish",30);
        availableFishes.add("stingray 4 5 30");
        pointValue.put("stingray",80);
        availableFishes.add("shark 4 2 20");
        pointValue.put("shark",100);
        availableFishes.add("treasureChest 10 10 0");
        pointValue.put("treasureChest",90);
    }

}

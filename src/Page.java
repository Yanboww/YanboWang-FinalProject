import java.util.ArrayList;
public class Page {
    private Background currentBackground;
    private ArrayList<Button> currentButtons;
    private String pageName;

    public Page(String name)
    {
        pageName = name;
        currentBackground = new Background(pageName);
        currentButtons = getButtons();
    }
    public ArrayList<Button> getButtons()
    {
        ArrayList<Button> pageButtons = new ArrayList<>();
        if(pageName.equals("menu"))
        {
            pageButtons.add(new Button("Play",200,400));
            pageButtons.add(new Button("Help",200,500));
            pageButtons.add(new Button("Quit",200,600));
        }
        else if(pageName.equals("game!"))
        {
            pageButtons.add(new Button("check FishDex",200,500));
            pageButtons.add(new Button("replay",200,500));
            pageButtons.add(new Button("exit",200,500));
        }
        else if(pageName.equals("Help"))
        {
            pageButtons.add(new Button("exit",200,500));
        }
        else if(pageName.equals("Play"))
        {
            pageButtons.add(new Button("Clear",200,500));
            pageButtons.add(new Button("Don't Clear",200,500));
        }
        else if(pageName.equals("PlayGame"))
        {
            pageButtons.add(new Button("pause",200,500));
        }
        else if(pageName.equals("pause"))
        {
            pageButtons.add(new Button("continue",200,500));
            pageButtons.add(new Button("check",200,500));
            pageButtons.add(new Button("return",200,500));
        }
        else if(pageName.equals("index"))
        {
            pageButtons.add(new Button("return",200,500));
        }
        return pageButtons;
    }

    public Background getCurrentBackground() {
        return currentBackground;
    }

    public ArrayList<Button> getCurrentButtons() {
        return currentButtons;
    }

    public String getPageName() {
        return pageName;
    }
}

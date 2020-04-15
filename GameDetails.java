import javax.swing.JPanel;
import java.awt.*;

public class GameDetails extends JPanel {
    private String state = "";
    private String errMsg = "";

    public GameDetails()
    {
        state = "Match in progress";
        setPreferredSize(new Dimension(250, 150));
        setOpaque(true);
    }

    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        showErrMsg(g);
        showState(g);
        showGameDts(g, new boolean[0]);
    }

    private void showState(Graphics g)
    {
        Font type = new Font("Garamond", Font.BOLD, 20);
        FontMetrics metrics = this.getFontMetrics(type);
        g.setFont(type);
        g.setColor(new Color(56,93,56));
        g.drawString(state, ((getWidth() / 2) - metrics.stringWidth(state)) / 2, 50);
    }

    public void changeState(String s)
    {
        state = s;
    }

    private void showErrMsg(Graphics g)
    {
        if(!errMsg.isEmpty())
        {
            Font type = new Font("Garamond", Font.PLAIN, 20);
            FontMetrics metrics = this.getFontMetrics(type);
            g.setFont(type);
            g.setColor(new Color(56,93,56));
            g.drawString(errMsg, ((getWidth() / 2) - metrics.stringWidth(errMsg)) / 2, 35);
            errMsg = "";
        }
    }

    public void changeErrMsg(String msg)
    {
        errMsg = msg;
    }

    private void showGameDts(Graphics g, boolean[] dealtState)
    {
        g.setColor(new Color(56, 93, 56));
        Font type = new Font("Garamond", Font.PLAIN, 20);
        g.setFont(type);
        FontMetrics metrics = this.getFontMetrics(type);

        int cardsDealt = 0;

        for(int i = 0; i < dealtState.length; ++i) {
            if(!dealtState[i])  {
                cardsDealt += 1;
           }
        }

        g.drawString("Cards dealt:" + cardsDealt, ((getWidth() / 2) - metrics.stringWidth("Cards dealt")) / 2 , 100);
        g.drawString("Cards left: " + (108 - cardsDealt), ((getWidth() / 2) - metrics.stringWidth("Cards left")) / 2, 100);
     }
   }

    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Abc
 */
public class lolChampions {
    
    private int champID;
    private String champName;
    private String champRole;
    private int price;
    private int skins;

    public lolChampions() {
        this.champID = 0;
        this.champName = "";
        this.champRole = "";
        this.price = 0;
        this.skins = 0;
    }
    
    public lolChampions(int champID, String champName, String champRole, int price, int skins) {
        this.champID = champID;
        this.champName = champName;
        this.champRole = champRole;
        this.price = price;
        this.skins = skins;
    }

    public int getChampID() {
        return champID;
    }

    public void setChampID(int champID) {
        this.champID = champID;
    }

    public String getChampName() {
        return champName;
    }

    public void setChampName(String champName) {
        this.champName = champName;
    }

    public String getChampRole() {
        return champRole;
    }

    public void setChampRole(String champRole) {
        this.champRole = champRole;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSkins() {
        return skins;
    }

    public void setSkins(int skins) {
        this.skins = skins;
    }

    @Override
    public String toString() {
        return "lolChampions{" + "champID=" + champID + ", champName=" + champName + ", champRole=" + champRole + ", price=" + price + ", skins=" + skins + '}';
    }
    
    
}

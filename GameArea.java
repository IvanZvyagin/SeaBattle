package SeaBattle;

import java.util.ArrayList;
import java.util.List;

public class GameArea {
private List<Ship>ships;
private static final int sizeArea = 10;
private static GameSymbol[][] areaSymbol;
private GameSymbol[][] opponentSymbol;
private Ship[][] ship;

    public GameArea() {
         areaSymbol = new GameSymbol[sizeArea][sizeArea];
         opponentSymbol = new GameSymbol[sizeArea][sizeArea];
         ships = new ArrayList<>();
         ship = new Ship[sizeArea][sizeArea];

        for (int i = 0; i < sizeArea; i++) {
            for (int j = 0; j < sizeArea; j++) {
                areaSymbol[i][j] = GameSymbol.EMPTY;
                opponentSymbol[i][j] = GameSymbol.EMPTY;
            }
        }
    }
    public static void printAreaPlayer(GameSymbol[][] emberns){
        for(GameSymbol[] element : areaSymbol){
            for(GameSymbol el : element){
                if(el == GameSymbol.EMPTY){
                    System.out.print(GameSymbol.EMPTY + " ");
                }else{
                    System.out.print(GameSymbol.HUGE + " ");
                }
            }
            System.out.println();
        }
    }
//    public static void printAreaOpponent(GameSymbol[][]opponentSymbol){
//        for (int i = 0; i < opponentSymbol.length; i++) {
//            for (int j = 0; j < opponentSymbol[i].length; j++) {
//                System.out.print(opponentSymbol[i][j]);
//            }
//            System.out.println();
//        }
//    }
    public boolean placeShips(GameSymbol item, List<String> coords){
        if(coords.size() != item.getSize()){
            System.out.println("Неверное количество координат");
            return false;
        }
        for(String g : coords) {
            if (!isValidCoordinate(g)) {
                System.out.println("Неверная координата " + g);
                return false;
            }
        }
            for (String g : coords) {
                int[] xy = parseCoord(g);// Проверка занята ли клетка
                int x = xy[0];
                int y = xy[1];
                if(areaSymbol[x][y] != GameSymbol.EMPTY){
                    System.out.println("Клетка уже занята " + g);
                    return false;
                }
            }
            if(isHasAdjancetShip(coords)){
                System.out.println("Корабль не может быть размещен слишком близко к другому кораблю");
                return false;
            }
            if(!isStraight(coords)){
                System.out.println("Корабль не прямолинейный");
                return false;
            }
            for (String p : coords){
                int[]xy = parseCoord(p);
                int x = xy[0];
                int y = xy[1];
                areaSymbol[x][y] = GameSymbol.HUGE;

            }
            Ship ship = new Ship(coords,item);
            ships.add(ship);
        printAreaPlayer(areaSymbol);
        return true;
    }
    public boolean isStraight(List<String> coordinates) {
        if (coordinates.size() == 1)
            return true;
        int[] first = parseCoord(coordinates.get(0));
        boolean sameX = true;
        boolean sameY = true;
        for (String crdnt : coordinates) {
            int[] xy = parseCoord(crdnt);
            if (xy[0] != first[0]) sameX = false;
            if (xy[1] != first[1]) sameY = false;

        }
        return sameX || sameY;
    }
    public boolean isHasAdjancetShip(List<String> newShipCoords){
        for(String coord : newShipCoords){
            int[] xy = parseCoord(coord);
            int x = xy[0], y = xy[1];
            for (int i = x - 1; i <= x + 1; i++) {
                for(int j = y -1; j <= y +1; j++){
                    if(i == x && j == y)
                        continue;
                    if(i >= 0 && i < sizeArea && j >= 0 && j < sizeArea){
                        if(areaSymbol[i][j] != GameSymbol.EMPTY){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
//    public boolean isEmpty(List<String>coord){
//    for (String g : coords) {
//        int[] xy = parseCoord(g);// Проверка занята ли клетка
//        int x = xy[0];
//        int y = xy[1];
//        if(areaSymbol[x][y] != GameSymbol.EMPTY){
//            System.out.println("Клетка уже занята " + g);
//            return false;
//        }
   // return true;
//    }

    public int[] parseCoord(String strs) {
        String[] ars = strs.split(",");
        return new int[]{Integer.parseInt(ars[0]), Integer.parseInt(ars[1])};
    }
    public boolean isValidCoordinate(String coord) {
        try {
        String[] strs = coord.split(",");
            int x = Integer.parseInt(strs[0]);
            int y = Integer.parseInt(strs[1]);
            return x >= 0 && x < sizeArea && y >= 0 && y < sizeArea;
        }catch (Exception e){
            return false;
        }
    }
//    public boolean isShipValid(List<String> coords){
//        if(coords.size() == 1)
//            return true;
//    }

    public List<Ship> getShips() {
        return ships;
    }

    public void setShips(List<Ship> ships) {
        this.ships = ships;
    }

    public Ship[][] getShip() {
        return ship;
    }

    public void setShip(Ship[][] ship) {
        this.ship = ship;
    }

    public GameSymbol[][] getAreaSymbol() {
        return areaSymbol;
    }

    public void setAreaSymbol(GameSymbol[][] areaSymbol) {
        this.areaSymbol = areaSymbol;
    }

    public GameSymbol[][] getOpponentSymbol() {
        return opponentSymbol;
    }

    public void setOpponentSymbol(GameSymbol[][] opponentSymbol) {
        this.opponentSymbol = opponentSymbol;
    }
}

package SeaBattle;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    private String name;
    private GameArea playerArea;


    public Player(String name) {
        this.playerArea = new GameArea();
        this.name = name;
    }

    public void placedShips(Scanner scanner) {
        System.out.println(name + " Заполните координаты кораблей: ");
        GameSymbol[] places = {GameSymbol.HUGE, GameSymbol.LARGE, GameSymbol.LARGE, GameSymbol.MEDIUM, GameSymbol.MEDIUM, GameSymbol.MEDIUM,
                GameSymbol.SMALL, GameSymbol.SMALL, GameSymbol.SMALL, GameSymbol.SMALL};

        for (GameSymbol ship : places) {
            boolean placed = false;
            while (!placed) {
                System.out.printf("Установите корабль %s %d палубный", ship.getDescription(), ship.getSize());
                try {
                    String str = scanner.nextLine();
                    ArrayList<String> shipsCoord = parsed(str);
                    placed = playerArea.placeShips(ship,shipsCoord);
                }catch (Exception e){
                    System.out.println("Error" + e);
                }
            }
        }
    }
        public ArrayList<String> parsed(String str) throws Exception{
            ArrayList<String> coord = new ArrayList<>();
            String[] keys = str.split(";");
            if(keys.length == 0){
                throw new Exception("Неверный формат ввода");
            }
            for(String s : keys){
                s = s.trim();
                if(!s.matches("\\d+,\\d+")){
                    throw new Exception("Неверная координата ");
                }else{
                    coord.add(s);
                }
            }
            return coord;
        }
//        public boolean metroShit(Scanner scanner,Player opponent){
//        opponent.getPlayerArea().printAreaPlayer(true);
//        }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GameArea getPlayerArea() {
        return playerArea;
    }

    public void setPlayerArea(GameArea playerArea) {
        this.playerArea = playerArea;
    }
}


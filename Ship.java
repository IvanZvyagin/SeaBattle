package SeaBattle;

import java.util.ArrayList;
import java.util.List;

public class Ship {
private List<String>coordinates;
private List<String>hits;
private GameSymbol type;

    public Ship(List<String> coordinates, GameSymbol type) {
        this.coordinates = new ArrayList<>(coordinates);
        this.hits = new ArrayList<>();
        this.type = type;
    }

    public boolean isShot(String coord){
        if(coordinates.contains(coord) && !hits.contains(coord)){
            hits.add(coord);
            return true;
        }
        return false;

    }
    public boolean isKill(){
        return hits.size() == coordinates.size();
    }

    public List<String> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<String> coordinates) {
        this.coordinates = coordinates;
    }

    public List<String> getHits() {
        return hits;
    }

    public void setHits(List<String> hits) {
        this.hits = hits;
    }

    public GameSymbol getType() {
        return type;
    }

    public void setType(GameSymbol type) {
        this.type = type;
    }
}



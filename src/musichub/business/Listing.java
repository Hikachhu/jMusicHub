package musichub.business;
import musichub.business.*;

import java.util.ArrayList;
import java.util.Scanner;

public interface Listing{
  public ArrayList<Stockage> Ensemble = new ArrayList<Stockage>();
  public void add(Stockage nouvelle);
  public String toString();
}

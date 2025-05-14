package cp241project;

import java.util.*;

public class GraphTournament implements GraphTournamentADT {
    private final GraphNode Gygee = new GraphNode(new Member("Gygee",Band.BNK48,1,Block.A));
    private final GraphNode Wee = new GraphNode(new Member("Wee",Band.BNK48,2,Block.C));
    private final GraphNode Orn = new GraphNode(new Member("Orn",Band.BNK48,3,Block.B));
    private final GraphNode Cherprang = new GraphNode(new Member("Cherprang",Band.BNK48,4,Block.D));
    private final GraphNode Kyla = new GraphNode(new Member("Kyla",Band.CGM48,5,Block.D));
    private final GraphNode Myyu = new GraphNode(new Member("Myyu",Band.BNK48,6,Block.B));
    private final GraphNode Milk = new GraphNode(new Member("Milk",Band.CGM48,7,Block.C));
    private final GraphNode Pun = new GraphNode(new Member("Pun",Band.BNK48,8,Block.A));
    private final GraphNode Korn = new GraphNode(new Member("Korn",Band.BNK48,9,Block.A));
    private final GraphNode Nicha = new GraphNode(new Member("Nicha",Band.CGM48,10,Block.C));
    private final GraphNode Minmin = new GraphNode(new Member("Minmin",Band.BNK48,11,Block.B));
    private final GraphNode Pakwan = new GraphNode(new Member("Pakwan",Band.BNK48,12,Block.D));
    private final GraphNode New = new GraphNode(new Member("New",Band.BNK48,13,Block.D));
    private final GraphNode Parima = new GraphNode(new Member("Parima",Band.CGM48,14,Block.A));
    private final GraphNode Nena = new GraphNode(new Member("Nena",Band.CGM48,15,Block.C));
    private final GraphNode Jennis = new GraphNode(new Member("Jennis",Band.BNK48,16,Block.B));
    private GraphNode currentMem;
    private final GraphNode[] memberList = {Gygee,Wee,Orn, Cherprang, Kyla,Myyu, Milk, Pun, Korn,Nicha, Minmin,Pakwan, New, Parima, Nena, Jennis};

    public GraphTournament(){
        setGraph();
    }

    public void checkMember(String nameIn) throws NullPointerException{
        currentMem = null;
        for (GraphNode member : memberList) {
            if (nameIn.equalsIgnoreCase(member.getDataMem().getMemName())) {
                currentMem = member;
                break;
            }
        }
        if(currentMem == null){
            throw new NullPointerException( "Not found or not in top-16: Please type again");
        }

    }
    private void setGraph(){  //Set relation between winner and loser.
        ArrayList<GraphNode> GygeeWin = new ArrayList<>(Arrays.asList(Wee,Orn,Pun,Parima));
        ArrayList<GraphNode> WeeWin = new ArrayList<>(Arrays.asList(Cherprang,Milk,Nena));
        ArrayList<GraphNode> CherprangWin = new ArrayList<>(Arrays.asList(Kyla,New));
        ArrayList<GraphNode> MilkWin = new ArrayList<>(Arrays.asList(Nicha));
        ArrayList<GraphNode> OrnWin = new ArrayList<>(Arrays.asList(Myyu,Minmin));
        ArrayList<GraphNode> MyyuWin = new ArrayList<>(Arrays.asList(Jennis));
        ArrayList<GraphNode> KylaWin = new ArrayList<>(List.of(Pakwan));
        ArrayList<GraphNode> PunWin = new ArrayList<>(List.of(Korn));
        Gygee.addMultiOutGoing(GygeeWin.iterator());
        Wee.addMultiOutGoing(WeeWin.iterator());
        Cherprang.addMultiOutGoing(CherprangWin.iterator());
        Milk.addMultiOutGoing(MilkWin.iterator());
        Orn.addMultiOutGoing(OrnWin.iterator());
        Myyu.addMultiOutGoing(MyyuWin.iterator());
        Kyla.addMultiOutGoing(KylaWin.iterator());
        Pun.addMultiOutGoing(PunWin.iterator());
        setGraphIngoing();
    }

    public void setGraphIngoing() {
        Wee.addInGoing(Gygee);
        Cherprang.addInGoing(Wee);
        Milk.addInGoing(Wee);
        Orn.addInGoing(Gygee);
        Myyu.addInGoing(Orn);
        Kyla.addInGoing(Cherprang);
        Pun.addInGoing(Gygee);
        Pakwan.addInGoing(Kyla);
        New.addInGoing(Cherprang);
        Nena.addInGoing(Wee);
        Nicha.addInGoing(Milk);
        Jennis.addInGoing(Myyu);
        Minmin.addInGoing(Orn);
        Korn.addInGoing(Pun);
        Parima.addInGoing(Gygee);
    }
    
    public String toString(){
        StringBuilder prepareReturn = new StringBuilder();
        prepareReturn.append(String.format("\t%s\tfrom%6s\tBlock%2s\tis rank%3d\n", currentMem.getDataMem().getMemName(), currentMem.getDataMem().getBandOrigin(), currentMem.getDataMem().getBlock(), currentMem.getDataMem().getRank()));
        prepareReturn.append("\n\tHas win with\n");
        List<GraphNode> MemWin = currentMem.getMemOutGoing();
        if(MemWin.isEmpty()){
            prepareReturn.append("\tNo One in the rank of top-16\n");
        } else{
            for(GraphNode x:MemWin){
                prepareReturn.append(String.format("\t- %s\tfrom%6s\tBlock%2s\trank%3d\n", x.getDataMem().getMemName(), x.getDataMem().getBandOrigin(), x.getDataMem().getBlock(), x.getDataMem().getRank()));
            }
        }
        
        
        List<GraphNode> Memlose = currentMem.getMemInGoing();
        
        if(Memlose.isEmpty()){
        	prepareReturn.append("\n\twinner\n");
        } else{
        	prepareReturn.append("\n\tHas lose with\n");
        	
            for(GraphNode x:Memlose){
            	prepareReturn.append(String.format("\t- %s\tfrom%6s\tBlock%2s\trank%3d\n", x.getDataMem().getMemName(), x.getDataMem().getBandOrigin(), x.getDataMem().getBlock(), x.getDataMem().getRank()));
            }
        }
        
        return prepareReturn.toString();
    }
}
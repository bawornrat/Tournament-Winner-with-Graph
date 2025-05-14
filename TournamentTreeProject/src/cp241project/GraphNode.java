package cp241project;

import java.util.*;

public class GraphNode implements GraphNodeADT{
    private Member dataMem;
    private List<GraphNode>  memOutGoing;
    private List<GraphNode>  memInGoing;
    public GraphNode(Member memIn){
        dataMem = memIn;
        memOutGoing = new ArrayList<>();
        memInGoing = new ArrayList<>();
    }

    public Member getDataMem(){
        return dataMem;
    }
    public void setDataMem(Member memIn){
        this.dataMem = memIn;
    }
    @Override
    public void addInGoing(GraphNode gNode) {
        memInGoing.add(gNode);
    }

    @Override
    public void addOutGoing(GraphNode gNode) {
        memOutGoing.add(gNode);
    }


    public void addMultiOutGoing(Iterator<GraphNode> MemOut) {
        while (MemOut.hasNext()){
            addOutGoing(MemOut.next());
        }

    }


    public void addMultiInGoing(Iterator<GraphNode> MemIn) {
        while (MemIn.hasNext()){
            addInGoing(MemIn.next());
        }
    }

    public List<GraphNode> getMemInGoing(){
        return  memInGoing;
    }

    public List<GraphNode> getMemOutGoing(){
        return  memOutGoing;
    }
}

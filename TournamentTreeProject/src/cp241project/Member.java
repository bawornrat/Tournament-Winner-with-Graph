package cp241project;
enum Band {BNK48, CGM48}
enum Block {A, B, C, D}
public class Member {

    private final String MemName;
    private final Band BandOrigin;
    private final int rankNum;
    private final Block BlockTeam;
    public Member(String name, Band bandIn, int rank, Block BlockTeamIn){
        MemName = name;
        rankNum = rank;
        BandOrigin = bandIn;
        BlockTeam = BlockTeamIn;
    }
    public String getMemName(){
        return MemName;
    }
    public Band getBandOrigin(){
        return BandOrigin;
    }
    public int getRank(){
        return rankNum;
    }
    public Block getBlock(){
        return BlockTeam;
    }
    public String toString(){
        return getMemName()+" from "+getBandOrigin()+" Block "+getBlock()+" is rank "+getRank();
    }
}

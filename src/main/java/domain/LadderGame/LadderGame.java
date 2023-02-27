package domain.LadderGame;

import domain.Collection.Participant;
import domain.Collection.Participants;
import domain.Collection.Result;
import domain.Collection.Results;
import domain.Ladder.Ladder;
import domain.util.SequenceSwapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderGame {
    
    private final Participants participants;
    private final Ladder ladder;
    
    private final Results results;
    private final SequenceSwapper swapper;
    
    private final Map<Participant, Result> gameResult = new HashMap<>();
    
    
    public LadderGame( Participants participants, Results results, Ladder ladder ) {
        this.participants = participants;
        this.results = results;
        this.ladder = ladder;
        this.swapper = SequenceSwapper.initialize(participants.getParticipantsNum());
    }
    
    public void run() {
        this.ladder.readLines(this.swapper);
        this.setGameResult();
    }
    
    
    private void setGameResult() {
        List<Integer> sequence = this.swapper.getSequence();
        int sequenceSize = sequence.size();
        for ( int i = 0; i < sequenceSize; i++ ) {
            int changedRank = sequence.get(i);
            this.gameResult.put(this.participants.get(changedRank), this.results.get(i));
        }
    }
    
    public Result getResultFrom( Participant participant ) {
        return this.gameResult.get(participant);
    }
    
    public Map<Participant, Result> getAllGameResult() {
        return new HashMap<>(this.gameResult);
    }
    
    public Participants getParticipants() {
        return this.participants;
    }
    
    public Ladder getLadder() {
        return this.ladder;
    }
    
    public Results getResults() {
        return this.results;
    }
}

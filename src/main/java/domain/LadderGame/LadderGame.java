package domain.LadderGame;

import domain.Collection.Participant;
import domain.Collection.Participants;
import domain.Collection.Result;
import domain.Collection.Results;
import domain.Ladder.Ladder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderGame {
    
    private final Participants participants;
    private final Ladder ladder;
    
    private final Results results;
    
    private final Map<Participant, Result> gameResult = new HashMap<>();
    
    
    public LadderGame( Participants participants, Results results, Ladder ladder ) {
        this.participants = participants;
        this.results = results;
        this.ladder = ladder;
    }
    
    
    public void run() {
        List<Integer> sequence = this.ladder.getSwappedSequence(this.participants.getParticipantsNum());
        this.makeGameResult(sequence);
    }
    
    private void makeGameResult( List<Integer> sequence ) {
        for ( int i = 0; i < sequence.size(); i++ ) {
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

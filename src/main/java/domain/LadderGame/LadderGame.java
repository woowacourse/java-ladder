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
    private static final String CANNOT_FIND_PARTICIPANT_MESSAGE = "해당 이름의 참가자는 없습니다.";
    
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
        List<Integer> sequence = this.ladder.getSwappedSequence(this.participants.getSize());
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
    
    public void validateNameToFind( String name ) {
        if ( name.equals("all") ) {
            return;
        }
        if ( this.participants.contains(name) ) {
            return;
        }
        throw new IllegalArgumentException(CANNOT_FIND_PARTICIPANT_MESSAGE);
    }
    
    public Ladder getLadder() {
        return this.ladder;
    }
    
    public Results getResults() {
        return this.results;
    }
}

package domain.Collection;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Participants {
    
    private final List<Participant> participants;
    
    private Participants( List<Participant> participants ) {
        this.participants = participants;
    }
    
    public static Participants of( List<String> names ) {
        List<Participant> participantList = names.stream()
                .map(Participant::from)
                .collect(Collectors.toList());
        return new Participants(participantList);
    }
    
    public void add( final Participant name ) {
        this.participants.add(name);
    }
    
    public int getSize() {
        return this.participants.size();
    }
    
    public Participant get( int index ) {
        return this.participants.get(index);
    }
    
    public boolean contains( String name ) {
        return this.participants.contains(Participant.from(name));
    }
    
    public List<Participant> getParticipants() {
        return Collections.unmodifiableList(this.participants);
    }
    
}


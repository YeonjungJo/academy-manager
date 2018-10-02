package zoe.academymanager.domain.room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;


    @Transactional(readOnly = false)
    public void save(Room room) {
        roomRepository.save(room);
    }

}

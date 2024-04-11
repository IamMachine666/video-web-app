package org.videosharing.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.videosharing.domain.Video;
import org.videosharing.exceptions.VideoAlreadyExistsException;
import org.videosharing.exceptions.VideoNotFoundException;
import org.videosharing.repo.VideoRepo;

import java.io.IOException;
import java.util.List;

@Service
@AllArgsConstructor
public class VideoServiceImpl implements VideoService {

    private VideoRepo repo;

    @Override
    @Transactional
    public Video getVideo(String name) {
        if(!repo.existsByName(name)){
            throw new VideoNotFoundException();
        }
        return repo.findByName(name);
    }

    @Override
    public List<Video> getAllVideoNames() {
        return repo.getAllEntryNames();
    }

    @Override
    @Transactional
    public void saveVideo(MultipartFile file, String name) throws IOException {
        if(repo.existsByName(name)){
            throw new VideoAlreadyExistsException();
        }
        Video newVid = new Video(name, file.getBytes());
        repo.save(newVid);
    }

}

package org.videosharing.services;

import org.springframework.web.multipart.MultipartFile;
import org.videosharing.domain.Video;

import java.io.IOException;
import java.util.List;

public interface VideoService {
    Video getVideo(String name);

    void saveVideo(MultipartFile file, String name) throws IOException;

    List<Video> getAllVideoNames();
}

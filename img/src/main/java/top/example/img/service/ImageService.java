package top.example.img.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.example.img.model.Image;
import top.example.img.repository.ImageRepository;

import java.util.List;
import java.util.Optional;

@Component
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    public Image addImage(Image image) {
        return imageRepository.save(image);
    }

    public List<Image> getImages() {
        return imageRepository.findAll();
    }

    public void deleteImage(Long imageId) {
        imageRepository.deleteById(imageId);
    }

}

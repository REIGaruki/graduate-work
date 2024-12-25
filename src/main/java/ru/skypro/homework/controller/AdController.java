package ru.skypro.homework.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.Ads;
import ru.skypro.homework.dto.CreateOrUpdateAd;
import ru.skypro.homework.dto.ExtendedAd;
import ru.skypro.homework.model.Ad;
import ru.skypro.homework.service.AdService;
import ru.skypro.homework.service.ImageService;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ads")
public class AdController {

    private final AdService adService;
    private final ImageService imageService;

    @GetMapping()
    public ResponseEntity<Ads> getAllAds() {
        return ResponseEntity.ok(adService.getAllAds());
    }

    @PostMapping()
    public ResponseEntity<Ad> addAd(@RequestBody CreateOrUpdateAd ad, @RequestBody MultipartFile image) {
        if (true) {
            return ResponseEntity.status(HttpStatus.CREATED).body(adService.addAd(ad, image));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExtendedAd> getAds(@PathVariable int id) {
        if (!adService.exists(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else if (true) {
            return ResponseEntity.ok(adService.getExtendedAd(id));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeAd(@PathVariable int id) {
        if (!adService.exists(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else if (false) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        } else if (true) {
            adService.deleteAd(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Ad> updateAds(@PathVariable int id, @RequestBody CreateOrUpdateAd adUpdate) {
        if (!adService.exists(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else if (false) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        } else if (true) {
            return ResponseEntity.ok(adService.updateAd(id, adUpdate));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @GetMapping("/me")
    public ResponseEntity<Ads> getAdsMe() {
        if (true) {
            return ResponseEntity.ok(adService.getAdsByUser());
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PatchMapping(value ="/{id}/image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<byte[]> updateImage(@PathVariable int id,
                                              @RequestBody MultipartFile image) throws IOException {
        if (!adService.exists(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else if (false) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        } else if (true) {
            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType("application/octet-stream"))
                    .body(adService.changeImage(id, image));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

}

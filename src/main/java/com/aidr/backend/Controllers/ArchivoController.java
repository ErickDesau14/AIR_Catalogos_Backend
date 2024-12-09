package com.aidr.backend.Controllers;

import com.aidr.backend.DTOs.ArchivoDTO;
import com.aidr.backend.Services.Implements.ArchivoServiceImpl;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("/api/v1/a/recurso")
@CrossOrigin(origins = "http://localhost:8100/")
@AllArgsConstructor
public class ArchivoController {

    private static final Logger log = LoggerFactory.getLogger(ArchivoController.class);
    @Autowired
    ArchivoServiceImpl archivoService;

    @PostMapping("/archivo")
    public ResponseEntity<ArchivoDTO> createArchivo(@RequestParam("file") MultipartFile file, @RequestParam("nombre") String nombre, @RequestParam("idEmpresa") Long idEmpresa) throws NoSuchPaddingException, IOException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        return archivoService.createArchivo(file, nombre, idEmpresa);
    }

    @PutMapping("/archivo/{idArchivo}")
    public ResponseEntity<ArchivoDTO> updateArchivo(@PathVariable(name = "idArchivo") Long idArchivo, @RequestParam(value = "file", required = false) MultipartFile file, @RequestParam("nombre") String nombre, @RequestParam(value = "archivo", required = false) byte[] archivoEntity, @RequestParam("idEmpresa") Long idEmpresa) throws IOException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        return archivoService.updateArchivo(idArchivo, file, nombre, idEmpresa);
    }

    @GetMapping("/archivo/{idRecurso}")
    public ResponseEntity<byte[]> getArchivoByRecurso(@PathVariable(name = "idRecurso") Long idRecurso) throws NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, UnsupportedEncodingException, BadPaddingException, InvalidKeyException {
        return archivoService.getArchivoByRecurso(idRecurso);
    }

    @DeleteMapping("/archivo/{idArchivo}")
    public void deleteArchivo(@PathVariable(name = "idArchivo") Long idArchivo) {
        archivoService.deleteArchivo(idArchivo);
    }
}

package com.hh.store.Utility;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Base64;

@Component
public class Base64ImageSaver {

public void imagesaver(String imageString)
{
    byte[] decodedBytes = Base64.getDecoder().decode(imageString);
    try {
        FileUtils.writeByteArrayToFile(new File("image1"), decodedBytes);

    }

catch (Exception e)
{
    System.out.println("there is an error");
}

}

}

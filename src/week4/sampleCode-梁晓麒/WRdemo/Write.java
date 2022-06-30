package com.ad.homework04.WRdemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface Write {

    void writeFile(File f) throws FileNotFoundException;

    File creatFile() throws IOException;
}

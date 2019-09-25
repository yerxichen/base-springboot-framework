package com.sjq.demo.serviceImpl;

import com.sjq.demo.entity.FmsFile;
import com.sjq.demo.mapper.FileMapper;
import com.sjq.demo.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private FileMapper fileMapper;
    @Override
    public List<FmsFile> getAllFiles() {
        return fileMapper.selectList(null);
    }
}

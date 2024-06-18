package com.aloha.security.service;

import com.aloha.security.dto.Files;
import com.aloha.security.mapper.FileMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private FileMapper fileMapper;
    @Value("${upload.path}") //application.properties 에 설정한 업로드 경로 가져옴
    private String uploadPath;

    @Override
    public List<Files> list() throws Exception {
        List<Files> fileList = fileMapper.list();
        return fileList;
    }

    @Override
    public Files select(int no) throws Exception {
        Files file = fileMapper.select(no);
        return file;
    }

    @Override
    public int insert(Files file) throws Exception {
        int result  = fileMapper.insert(file);

        return result;
    }

    @Override
    public int update(Files file) throws Exception {
        int result = fileMapper.update(file);

        return result;
    }

    @Override
    public int delete(int no) throws Exception {
        // 파일 정보 조회
        Files file = fileMapper.select(no);

        // DB 파일 정보 삭제
        int result = fileMapper.delete(no);

        // 파일 시스템의 파일 삭제
        if( result > 0 ) {
            String filePath = file.getFilePath();
            File deleteFile = new File(filePath);
            // 파일 존재 확인
            if( !deleteFile.exists() ) {
                return result;
            }
            // 파일 삭제
            if( deleteFile.delete() ) {
                log.info("파일이 정상적으로 삭제 되었습니다.");
                log.info("file : " + filePath);
            } else {
                log.info("파일 삭제에 실패하였습니다.");
            }
        }
        return result;
    }

    @Override
    public List<Files> listByParent(Files file) throws Exception {
        List<Files> fileList = fileMapper.listByParent(file);
        return fileList;
    }

    @Override
    public int deleteByParent(Files file) throws Exception {
        List<Files> fileList = fileMapper.listByParent(file);

        for( Files deleteFile : fileList) {
            int no = deleteFile.getNo();
            delete(no);
        }
        int result = fileMapper.deleteByParent(file);
        log.info(result + "개의 파일을 삭제하였습니다.");
        return result;
    }

    @Override
    public boolean upload(Files file) throws Exception {
        log.info("file : " + file);

        MultipartFile mf = file.getFile();
        //파일 정보 : 원본파일명, 파일 용량 , 파일 데이터
        String originName = mf.getOriginalFilename();
        long fileSize = mf.getSize();
        byte[] fileData = mf.getBytes();

        log.info("원본 파일명 : " + originName);
        log.info("파일 용량 : " + fileSize);
        log.info("파일 데이터 : " + fileData);

        // 파일 업로드
        // 업로드 경로 - application.properties (upload.path)
        // 파일명 - 파일명 중복 방지를 위해 UID_파일명.xx 형식으로 지정
        // 업로드 파일명 : UID_원본파일명.xxx
        String fileName = UUID.randomUUID().toString() + "_" + originName;

        File uploadFile = new File(uploadPath,fileName);

        // 파일 업로드
        FileCopyUtils.copy(fileData, uploadFile);

        // 파일 정보 등록
        file.setFileName(fileName);
        file.setOriginName(originName);
        //filePath C:/upload/UID_원본파일명.xxx
        String filePath = uploadPath + "/" + fileName;
        file.setFilePath(filePath);
        file.setFileSize(fileSize);
        // file.setFileCode(0);
        fileMapper.insert(file);

        return true;
    }

    @Override
    public Files download(int no) throws Exception {
        Files file = fileMapper.select(no);

        // 다운로드 시, 추가 작업
        // ...
        return file;
    }
}

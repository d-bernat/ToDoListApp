package de.itbernat.springmvc.service;

import de.itbernat.springmvc.model.MetaInfo;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class MetaInfoServiceImpl implements MetaInfoService
{
    @Override
    public MetaInfo getMetaInfo()
    {
        MetaInfo metaInfo = new MetaInfo();
        metaInfo.setApplicationName("ToDoListApp");
        metaInfo.setTime(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
        return metaInfo;
    }
}

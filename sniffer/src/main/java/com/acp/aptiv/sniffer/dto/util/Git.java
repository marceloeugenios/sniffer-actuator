package com.acp.aptiv.sniffer.dto.util;

import com.acp.aptiv.sniffer.dto.util.Build;
import com.acp.aptiv.sniffer.dto.util.Commit;
import lombok.Getter;

@Getter
public class Git {

    private String branch;
    private Commit commit;
    private Build build;

}

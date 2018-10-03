package zoe.academymanager.domain;

import com.google.common.collect.ImmutableList;

import java.util.List;

public enum EnableStatus {
    ACTIVE, INACTIVE, DELETED;

    public static final List<EnableStatus> NOT_DELETED = ImmutableList.of(ACTIVE, INACTIVE);
}

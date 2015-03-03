package <%=packageName%>.domain;

import org.apache.commons.lang.StringUtils;

/**
 * Supported externa providers.  
 */
public enum ExternalAccountProvider {
	<%= _.invoke(externalauthProviders, String.prototype.toUpperCase).join(", ") %>;

    public static ExternalAccountProvider caseInsensitiveValueOf(String value) {
        if (StringUtils.isNotBlank(value))
            return ExternalAccountProvider.valueOf(value.toUpperCase());
        else
            return null;
    }
}

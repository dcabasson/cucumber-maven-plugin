# Cucumber Maven Plugin

This plugin for maven allows the generation of documentation based on some cucumber files.

usage:
	<plugin>
		<groupId>org.codehaus.mojo</groupId>
		<artifactId>cucumber-maven-plugin</artifactId>
		<version>1.0-SNAPSHOT</version>
		<configuration>
		   <featuresDirectory>project/directory/that/has/features/in/it</featuresDirectory>
		   <confluenceUrl>http://confluenceserverUrl</confluenceUrl>
		   <confluenceUsername>${confluence.username}</confluenceUsername>
		   <confluencePassword>${confluence.password}</confluencePassword>
		   <confluenceSpaceKey>SPACE_KEY</confluenceSpaceKey>
		   <confluenceParentPage>My Applications Features Page</confluenceParentPage>
		   <confluenceWsdlVersion>1 or 2</confluenceWsdlVersion>
		   <urlScm>scm:svn:scm_url</urlScm>
		   <username>readonlyuser</username>
		   <password>readonlypassword</password>
		</configuration>
	</plugin>

# Recipe For Hello Wold Application

## Introduction

The `hello-world.bb` recipe file is used to build and package a C++ application called "Test_CPP" along with a custom systemd service file named "Test_CPP.service". This documentation provides details on how to add the recipe to a Yocto Project, create the custom service file, install it, and perform various service management tasks.

## Recipe Structure

The `hello-world.bb` recipe file follows a standard structure for Yocto recipes. It includes metadata, source URI, package version, source directory, inheritance, build options, installation instructions, and file inclusion directives.

## Recipe Content

### Metadata

- `LICENSE`: Specifies the licensing information for the package.
- `LIC_FILES_CHKSUM`: Checksum of license files.

### Source

- `SRC_URI`: Points to the Git repository containing the source code for the C++ application.
- `SRCREV`: Automatically gets the latest revision from Git.

### Inheritance

- Inherits `cmake` and `systemd` classes for handling build and installation.

### Build and Installation

- `EXTRA_OECMAKE`: Extra options to pass to cmake during the build.
- `SYSTEMD_AUTO_ENABLE`: Enables the systemd service by default.

### Installation Instructions

- `do_install()`: Overrides the default installation function to install files into the root filesystem.
    - Installs the C++ executable and the systemd service file.

### File Inclusion

- `FILES:${PN}`: Specifies files to be included in the package.
    - Includes the C++ executable and the systemd service file.

## Custom Service File: Test_CPP.service

The `Test_CPP.service` file is a custom systemd service file associated with the "hello-world" package. It defines the service description, startup command, service type, kill mode, and installation target.

### Service Description

- Describes the purpose of the service (`Description`).

### Service Configuration

- `ExecStart`: Specifies the command to start the service.
- `Type`: Defines the type of service (simple in this case).
- `KillMode`: Specifies how to kill the service process.

### Installation Configuration

- `WantedBy`: Specifies when the service should be started (multi-user.target).

## Testing

To verify the installation and functionality of the "hello-world" application and the associated systemd service, follow these steps:

1. **Check Service Status**:
    
    - Verify that the service is running without any errors by checking its status:

![image](https://github.com/t0ti20/Yocto_Projects/assets/61616031/cc02250a-23b3-4d80-86cc-7d520877625f)

2. **Start the Service**:
    
    - Run the following command to start the "Test_CPP" service:
        
![image](https://github.com/t0ti20/Yocto_Projects/assets/61616031/21a42c96-34af-4b7a-979b-8f1f69c6c566)

3. **Verify Output**:
    
    - Check the output of the "hello-world" application to ensure it is functioning correctly:
![image](https://github.com/t0ti20/Yocto_Projects/assets/61616031/e8f66f8f-69a5-4084-b55b-1eed9faacb50)

        
4. **Stop the Service** (Optional):
    
    - If needed, you can stop the service using the following command:

![image](https://github.com/t0ti20/Yocto_Projects/assets/61616031/5a37a452-a1f9-4c85-a515-4a38d3e01026)


## Conclusion

This documentation outlines the structure and content of the `hello-world.bb` recipe file, as well as the custom systemd service file `Test_CPP.service`. It provides details on the recipe's metadata, source, inheritance, build, installation, and file inclusion. Additionally, it describes the configuration of the custom service file and its purpose within the Yocto Project environment.

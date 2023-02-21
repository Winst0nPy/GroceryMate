import click
import os


@click.command()
@click.argument('project_path', type=click.Path(exists=False))
@click.option('--company', prompt='Company name', help='The name of the company')
@click.option('--project', prompt='Project name', help='The name of the project')
def create_rest_api_project(project_path, company, project):
    """Create the directory structure for a Spring Boot REST API project using the MVC pattern."""
    base_dir = os.path.join(project_path, 'src', 'main', 'java', 'com', company, project)

    try:
        os.makedirs(base_dir)
    except FileNotFoundError as e:
        if click.confirm(f"Directory {os.path.dirname(base_dir)} does not exist. Create it?"):
            os.makedirs(os.path.dirname(base_dir))
            os.makedirs(base_dir)
        else:
            click.echo(f"Aborting: {str(e)}")
            return
    except FileExistsError as e:
        if not click.confirm(f"Directory {base_dir} already exists. Overwrite it?"):
            click.echo("Aborting.")
            return
        else:
            for dirpath, dirnames, filenames in os.walk(base_dir, topdown=False):
                for filename in filenames:
                    os.remove(os.path.join(dirpath, filename))
                for dirname in dirnames:
                    os.rmdir(os.path.join(dirpath, dirname))

    # Create the directories for the MVC components and DTO
    mvc_dirs = ['controller', 'model', 'repository', 'service']
    dto_dir = os.path.join(base_dir, 'dto')
    dto_subdirs = ['request', 'response']
    for mvc_dir in mvc_dirs:
        os.makedirs(os.path.join(base_dir, mvc_dir))
    os.makedirs(dto_dir)
    for subdir in dto_subdirs:
        os.makedirs(os.path.join(dto_dir, subdir))

    click.echo("Project structure created successfully!")


if __name__ == '__main__':
    create_rest_api_project()
